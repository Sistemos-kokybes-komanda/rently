CREATE TABLE `users`(
                        `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        `name` VARCHAR(255) NOT NULL,
                        `surname` VARCHAR(255) NOT NULL,
                        `email` VARCHAR(255) NOT NULL,
                        `password` VARCHAR(255) NOT NULL,
                        `phone_number` VARCHAR(255) NOT NULL,
                        `description` VARCHAR(255) NULL
);

ALTER TABLE
    `users` ADD UNIQUE `users_email_unique`(`email`);
ALTER TABLE
    `users` ADD UNIQUE `users_phone_number_unique`(`phone_number`);
CREATE TABLE `reviews`(
                          `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          `reservation_id` INT NOT NULL,
                          `rating` INT NOT NULL,
                          `comment` VARCHAR(255) NULL
);
ALTER TABLE
    `reviews` ADD INDEX `reviews_reservation_id_index`(`reservation_id`);
CREATE TABLE `reservations`(
                               `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                               `user_id` INT NOT NULL,
                               `garage_id` INT NOT NULL,
                               `start_date` DATETIME NOT NULL,
                               `end_date` DATETIME NOT NULL
);
ALTER TABLE
    `reservations` ADD INDEX `reservations_user_id_index`(`user_id`);
ALTER TABLE
    `reservations` ADD INDEX `reservations_garage_id_index`(`garage_id`);
CREATE TABLE `garages`(
                          `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          `summary` VARCHAR(255) NULL,
                          `address` VARCHAR(255) NOT NULL,
                          `price` DOUBLE(8, 2) NOT NULL,
                          `owner_id` INT NOT NULL
);
ALTER TABLE
    `garages` ADD UNIQUE `garages_address_unique`(`address`);
ALTER TABLE
    `garages` ADD INDEX `garages_owner_id_index`(`owner_id`);
ALTER TABLE
    `reservations` ADD CONSTRAINT `reservations_user_id_foreign` FOREIGN KEY(`user_id`) REFERENCES `users`(`id`);
ALTER TABLE
    `garages` ADD CONSTRAINT `garages_owner_id_foreign` FOREIGN KEY(`owner_id`) REFERENCES `users`(`id`);
ALTER TABLE
    `reservations` ADD CONSTRAINT `reservations_garage_id_foreign` FOREIGN KEY(`garage_id`) REFERENCES `garages`(`id`);
ALTER TABLE
    `reviews` ADD CONSTRAINT `reviews_reservation_id_foreign` FOREIGN KEY(`reservation_id`) REFERENCES `reservations`(`id`);
-- Populate users table
INSERT INTO `users` (`name`, `surname`, `email`, `password`, `phone_number`, `description`)
VALUES
    ('John', 'Doe', 'john.doe@example.com', 'password123', '+123456789', 'A user with a description'),
    ('Alice', 'Smith', 'alice.smith@example.com', 'pass456word', '+987654321', NULL);

-- Populate garages table
INSERT INTO `garages` (`summary`, `address`, `price`, `owner_id`)
VALUES
    ('Garage 1', '123 Main St', 50.00, 1),
    ('Garage 2', '456 Oak St', 40.00, 2);

-- Populate reservations table
INSERT INTO `reservations` (`user_id`, `garage_id`, `start_date`, `end_date`)
VALUES
    (1, 2, '2023-01-01 08:00:00', '2023-01-02 18:00:00'),
    (2, 1, '2023-02-15 12:00:00', '2023-02-17 15:00:00');

-- Populate reviews table
INSERT INTO `reviews` (`reservation_id`, `rating`, `comment`)
VALUES
    (1, 4, 'Great experience!'),
    (2, 5, 'Excellent service and clean garage');