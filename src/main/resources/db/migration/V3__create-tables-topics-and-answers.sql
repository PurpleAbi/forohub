CREATE TABLE topics(
                       id                  INT          not null auto_increment,
                       title               VARCHAR(100) not null unique,
                       message             VARCHAR(200) not null unique,
                       date_of_creation    VARCHAR(14)  not null,
                       status              VARCHAR(100) not null,
                       profile_id          INT not null,
                       course_id           INT not null,

                           PRIMARY KEY (id),
                           CONSTRAINT fk_topics_profile_id FOREIGN KEY (profile_id) REFERENCES profiles(id),
                           CONSTRAINT fk_topics_course_id FOREIGN KEY (course_id) REFERENCES courses(id)
);

CREATE TABLE answers(
                       id                  INT          not null auto_increment,
                       message             VARCHAR(200) not null unique,
                       date_of_creation    VARCHAR(14)  not null,
                       solution            VARCHAR(100) not null,
                       profile_id          INT not null,
                       topic_id            INT not null,

                       PRIMARY KEY (id),
                       CONSTRAINT fk_answers_profile_id FOREIGN KEY (profile_id) REFERENCES profiles(id),
                       CONSTRAINT fk_answers_topic_id FOREIGN KEY (topic_id) REFERENCES topics(id)
);