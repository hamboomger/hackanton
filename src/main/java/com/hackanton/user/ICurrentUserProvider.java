package com.hackanton.user;

import org.jetbrains.annotations.Nullable;

/**
 * @author ddorochov
 */
public interface ICurrentUserProvider {
	@Nullable
	User getCurrentUser();
}
