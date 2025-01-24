create TABLE wps_app_data.welding_parameters (
    id INT AUTO_INCREMENT PRIMARY KEY,
    parameter_name VARCHAR(255) NOT NULL,
    value VARCHAR(255) NOT NULL,
    wps_id INT NOT NULL,
    FOREIGN KEY (wps_id) REFERENCES wps(id)
);