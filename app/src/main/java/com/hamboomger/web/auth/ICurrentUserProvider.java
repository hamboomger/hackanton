package com.hamboomger.web.auth;

import com.hamboomger.model.common.User;

/**
 * @author ddorochov
 */
public interface ICurrentUserProvider {
	User getCurrentUser();
}
