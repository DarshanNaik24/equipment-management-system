CREATE TABLE equipment_type (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE equipment (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    last_cleaned_date DATE NOT NULL,
    type_id BIGINT NOT NULL,
    CONSTRAINT fk_equipment_type
        FOREIGN KEY (type_id)
        REFERENCES equipment_type(id)
        ON DELETE RESTRICT
);

CREATE TABLE maintenance_log (
    id BIGSERIAL PRIMARY KEY,
    equipment_id BIGINT NOT NULL,
    maintenance_date DATE NOT NULL,
    notes VARCHAR(500) NOT NULL,
    performed_by VARCHAR(255) NOT NULL,
    CONSTRAINT fk_maintenance_equipment
        FOREIGN KEY (equipment_id)
        REFERENCES equipment(id)
        ON DELETE CASCADE
);