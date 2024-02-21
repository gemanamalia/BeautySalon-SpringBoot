-- Crearea tabelului Client
CREATE TABLE IF NOT EXISTS client (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Crearea tabelului Review
CREATE TABLE IF NOT EXISTS review (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    client_id BIGINT,
    rating INT,
    comment VARCHAR(255),
    timestamp TIMESTAMP,
    FOREIGN KEY (client_id) REFERENCES client(id)
);

-- Crearea tabelului BeautyProfessional
CREATE TABLE IF NOT EXISTS beauty_professional (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    specialization VARCHAR(255)
);

-- Crearea tabelului Appointment
CREATE TABLE IF NOT EXISTS appointment (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    client_id BIGINT,
    professional_id BIGINT,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    FOREIGN KEY (client_id) REFERENCES client(id),
    FOREIGN KEY (professional_id) REFERENCES beauty_professional(id)
);

-- Crearea tabelului Product
CREATE TABLE IF NOT EXISTS product (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL
);

-- Crearea tabelului AppointmentProduct (tabel de legătură pentru relația M:M între Appointment și Product)
CREATE TABLE IF NOT EXISTS appointment_product (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    appointment_id BIGINT,
    product_id BIGINT,
    FOREIGN KEY (appointment_id) REFERENCES appointment(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);
