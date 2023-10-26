package com.eltex;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record User(
        @NotNull long id,
        @NotNull String login,
        @NotNull String name,
        @Nullable String avatar) {

    public static class Builder {
        @NotNull private long id;
        @NotNull private String login;
        @NotNull private String name;
        @Nullable private String avatar;

        public User build() {
            return new User(
                    id,
                    login,
                    name,
                    avatar);
        }

        public void setId(final long id) {
            this.id = id;
        }

        public void setLogin(final String login) {
            this.login = login;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public void setAvatar(final String avatar) {
            this.avatar = avatar;
        }
    }
}
