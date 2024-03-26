package com.vizhu.vizhu.repo;

import java.time.LocalDateTime;

public interface Timestampable {
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
}