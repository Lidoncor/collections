package com.eltex;

import org.jetbrains.annotations.Nullable;

public record UserPreview(long id, @Nullable String avatar) {
}
