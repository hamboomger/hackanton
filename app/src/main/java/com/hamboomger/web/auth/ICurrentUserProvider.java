package com.hamboomger.web.auth;

import com.hamboomger.model.common.User;
import org.jetbrains.annotations.Nullable;

/**
 * @author ddorochov
 */
public interface ICurrentUserProvider {
	@Nullable
	User getCurrentUser();
}
