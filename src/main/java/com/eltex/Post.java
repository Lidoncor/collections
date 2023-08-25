package com.eltex;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public record Post(
        long id,
        String content,
        String author,
        List<Long> likeOwnerIds,
        List<Long> mentionIds,
        Map<Long, UserPreview> users
) {

    public Builder builder() {
        return new Builder()
                .setId(id)
                .setContent(content)
                .setAuthor(author)
                .setLikeOwnerIds(likeOwnerIds)
                .setMentionIds(mentionIds)
                .setUsers(users);
    }

    public static class Builder {
        private long id = 0L;
        private String content = "";
        private String author = "";
        private List<Long> likeOwnerIds = Collections.emptyList();
        private List<Long> mentionIds = Collections.emptyList();
        private Map<Long, UserPreview> users = Collections.emptyMap();

        public Builder setId(final long id) {
            this.id = id;
            return this;
        }

        public Builder setContent(final String content) {
            this.content = content;
            return this;
        }

        public Builder setAuthor(final String author) {
            this.author = author;
            return this;
        }

        public Builder setLikeOwnerIds(final List<Long> likeOwnerIds) {
            this.likeOwnerIds = likeOwnerIds;
            return this;
        }

        public Builder setMentionIds(final List<Long> mentionIds) {
            this.mentionIds = mentionIds;
            return this;
        }

        public Builder setUsers(final Map<Long, UserPreview> users) {
            this.users = users;
            return this;
        }

        public Post build() {
            return new Post(id, content, author, likeOwnerIds, mentionIds, users);
        }
    }
}
