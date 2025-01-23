CREATE TABLE wps_app_data.users (
    id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    pass VARCHAR(255),
    email VARCHAR(255),
    access_right_level TINYINT UNSIGNED,
    save_path VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)