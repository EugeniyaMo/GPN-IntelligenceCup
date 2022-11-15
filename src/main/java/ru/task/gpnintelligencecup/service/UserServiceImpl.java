package ru.task.gpnintelligencecup.service;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.ServiceClientCredentialsFlowResponse;
import com.vk.api.sdk.objects.groups.responses.IsMemberUserIdsResponse;
import com.vk.api.sdk.objects.users.responses.GetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.task.gpnintelligencecup.models.User;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private VkApiClient vkApiClient;

    @Value("${cup.appid}")
    private int appId;

    @Value("${cup.secret}")
    private String clientSecret;

    private String getAccessToken() throws ClientException, ApiException {
        ServiceClientCredentialsFlowResponse authResponse = vkApiClient.oAuth()
                .serviceClientCredentialsFlow(appId, clientSecret)
                .execute();

        return authResponse.getAccessToken();
    }

    public GetResponse getUserById(String id) throws ClientException, ApiException {
        ServiceActor actor = new ServiceActor(appId, getAccessToken());
        Optional<GetResponse> getResponse = vkApiClient.users().get(actor).userIds(id).execute().stream().findFirst();
        if (getResponse.isEmpty()) {
            throw new ClientException("No such user " + id);
        }
        return getResponse.get();
    }

    public boolean isMember(String userId, String groupId, String userAccessToken) throws ClientException, ApiException {
        ServiceActor actor = new ServiceActor(appId, userAccessToken);
        Optional<IsMemberUserIdsResponse> getResponse = vkApiClient.groups().
                isMemberWithUserIds(actor, groupId, Integer.valueOf(userId)).execute().stream().findFirst();
        if (getResponse.isEmpty()) {
            throw new ClientException("No such member " + userId + " or such group" + groupId);
        }
        return getResponse.get().isMember();
    }

    public User getUserInfo(String userId, String groupId, String userAccessToken) throws ClientException, ApiException {
        GetResponse userInfo = getUserById(userId);
        boolean member = isMember(userId, groupId, userAccessToken);
        User user = new User(userInfo.getFirstName(), userInfo.getLastName(), member);
        return user;
    }
}
