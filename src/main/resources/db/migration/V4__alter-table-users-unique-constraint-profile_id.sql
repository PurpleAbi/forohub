ALTER TABLE users
    ADD CONSTRAINT uq_users_profile_id UNIQUE (profile_id);