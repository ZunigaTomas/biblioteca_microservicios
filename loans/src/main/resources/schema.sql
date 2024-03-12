DROP TABLE IF EXISTS loans;

CREATE TABLE IF NOT EXISTS loans (
     `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
     `user_id` BIGINT NOT NULL,
     `book_id` BIGINT NOT NULL,
     `loan_number` BIGINT NOT NULL,
     `loan_date` TIMESTAMP NOT NULL,
     `return_date` TIMESTAMP,
     `created_at` TIMESTAMP NOT NULL,
     `created_by` varchar(20) NOT NULL,
     `updated_at` TIMESTAMP DEFAULT NULL,
     `updated_by` varchar(20) DEFAULT NULL
);
