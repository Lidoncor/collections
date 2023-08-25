package com.eltex;

import java.util.*;

public class WallService {
    private long nextId = 1L;
    private final List<Post> posts = new ArrayList<>();

    public void addPost(final String content) {
        posts.add(
                new Post.Builder()
                        .setId(nextId++) // Оператор ++ сначала читает значение, затем увеличивает на 1
                        .setContent(content)
                        .build()
        );
    }

    public Post getPostById(final long postId) {
        Post post = null;
        for (final Post iterated : posts) {
            if (iterated.id() == postId) {
                post = iterated;
                break;
            }
        }

        return post;
    }

    // Здесь итератор использовать не получится – нужен индекс
    public void updatePost(final Post updated) {
        for (int i = 0; i < posts.size(); i++) {
            final Post iterated = posts.get(i);

            if (iterated.id() == updated.id()) {
                posts.set(i, updated);
                break;
            }
        }
    }

    public void like(final long postId, final long userId) {
        final Post post = getPostById(postId);

        final var mutableLikeOwnerIds = new ArrayList<>(post.likeOwnerIds());

        if (mutableLikeOwnerIds.contains(userId)) {
            mutableLikeOwnerIds.remove(userId);
        } else {
            mutableLikeOwnerIds.add(userId);
        }

        final var allUserIds = new HashSet<>(post.mentionIds());
        allUserIds.addAll(mutableLikeOwnerIds);
        final var users = new HashMap<Long, UserPreview>();
        for (final long id : allUserIds) {
            users.put(id, new UserPreview(id, null));
        }

        updatePost(
                post.builder()
                        .setLikeOwnerIds(Collections.unmodifiableList(mutableLikeOwnerIds))
                        .setUsers(Collections.unmodifiableMap(users))
                        .build()
        );
    }

    public void setContent(final long postId, final String content) {
        updatePost(
                getPostById(postId)
                        .builder()
                        .setContent(content)
                        .build()
        );
    }

    public void setAuthor(final long postId, final String author) {
        updatePost(
                getPostById(postId)
                        .builder()
                        .setAuthor(author)
                        .build()
        );
    }

    // Выдаём копию
    public List<Post> getPosts() {
        return new ArrayList<>(posts);
    }
}
