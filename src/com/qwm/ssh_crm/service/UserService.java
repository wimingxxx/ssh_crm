package com.qwm.ssh_crm.service;

import com.qwm.ssh_crm.domain.User;

/**
 * @author：qiwenming
 * @date：2017/11/2 0002   21:48
 * @description：
 */
public interface UserService {
    User getUserByCodePassword();
}
