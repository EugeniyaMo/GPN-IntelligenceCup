package ru.task.gpnintelligencecup.service;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.users.responses.GetResponse;
import ru.task.gpnintelligencecup.models.User;


public interface UserService {

    GetResponse getUserById(String id) throws ClientException, ApiException;
    boolean isMember(String userId, String groupId, String userAccessToken) throws ClientException, ApiException;
    User getUserInfo(String userId, String groupId, String userAccessToken) throws ClientException, ApiException;
}
