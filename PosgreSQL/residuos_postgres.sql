-- 1. Crear la base de datos
-- Terminar conexiones activas y recrear base de datos
SELECT pg_terminate_backend (pid)
FROM pg_stat_activity
WHERE
    datname = 'ResiduosToxicos'
    AND pid <> pg_backend_pid ();

DROP DATABASE IF EXISTS "ResiduosToxicos";

CREATE DATABASE "ResiduosToxicos";

\c "ResiduosToxicos";

-- 2. Eliminar tablas existentes en orden correcto (por dependencias)
DROP TABLE IF EXISTS TRASLADO_RESIDUO CASCADE;

DROP TABLE IF EXISTS RESIDUO_CONSTITUYENTE CASCADE;

DROP TABLE IF EXISTS RESIDUO CASCADE;

DROP TABLE IF EXISTS CONSTITUYENTE CASCADE;

DROP TABLE IF EXISTS DESTINO CASCADE;

DROP TABLE IF EXISTS EMPRESA_TRANSPORTISTA CASCADE;

DROP TABLE IF EXISTS EMPRESA_PRODUCTORA CASCADE;

DROP TABLE IF EXISTS CODIGO_RESIDUO CASCADE;

DROP TABLE IF EXISTS REGION CASCADE;

-- 3. REGION
CREATE TABLE REGION (
    RegCod INTEGER PRIMARY KEY,
    RegNom VARCHAR(100) NOT NULL,
    EstReg CHAR(1) NOT NULL DEFAULT 'A'
);

-- 4. CODIGO_RESIDUO
CREATE TABLE CODIGO_RESIDUO (
    CodResCod VARCHAR(10) PRIMARY KEY,
    CodResDesc VARCHAR(200) NOT NULL,
    CodResEstReg CHAR(1) NOT NULL DEFAULT 'A',
    EstReg CHAR(1) NOT NULL DEFAULT 'A'
);

-- 5. EMPRESA_PRODUCTORA
CREATE TABLE EMPRESA_PRODUCTORA (
    EmpCod SERIAL PRIMARY KEY,
    EmpNom VARCHAR(200) NOT NULL,
    EmpRUC VARCHAR(11) NOT NULL,
    EmpDir VARCHAR(250) NOT NULL,
    EmpAct VARCHAR(100),
    RegCod INTEGER NOT NULL REFERENCES REGION (RegCod),
    EstReg CHAR(1) NOT NULL DEFAULT 'A'
);

-- 6. EMPRESA_TRANSPORTISTA
CREATE TABLE EMPRESA_TRANSPORTISTA (
    TrsEmpCod SERIAL PRIMARY KEY,
    TrsNom VARCHAR(200) NOT NULL,
    TrsRUC VARCHAR(11) NOT NULL,
    TrsDir VARCHAR(250) NOT NULL,
    TrsCap NUMERIC(8, 2),
    RegCod INTEGER NOT NULL REFERENCES REGION (RegCod),
    EstReg CHAR(1) NOT NULL DEFAULT 'A'
);

-- 7. DESTINO
CREATE TABLE DESTINO (
    DestCod SERIAL PRIMARY KEY,
    DestNom VARCHAR(100) NOT NULL,
    DestDir VARCHAR(250) NOT NULL,
    DestCap NUMERIC(10, 2),
    DestCapAct NUMERIC(10, 2),
    RegCod INTEGER NOT NULL REFERENCES REGION (RegCod),
    EstReg CHAR(1) NOT NULL DEFAULT 'A'
);

-- 8. CONSTITUYENTE
CREATE TABLE CONSTITUYENTE (
    ConsCod SERIAL PRIMARY KEY,
    ConNom VARCHAR(100) NOT NULL,
    ConDes VARCHAR(250),
    ConGrad SMALLINT,
    EstReg CHAR(1) NOT NULL DEFAULT 'A'
);

-- 9. RESIDUO
CREATE TABLE RESIDUO (
    ResCod SERIAL PRIMARY KEY,
    ResNom VARCHAR(100) NOT NULL,
    ResDes VARCHAR(250),
    CodResCod VARCHAR(10) NOT NULL REFERENCES CODIGO_RESIDUO (CodResCod),
    EmpCod INTEGER NOT NULL REFERENCES EMPRESA_PRODUCTORA (EmpCod),
    EstReg CHAR(1) NOT NULL DEFAULT 'A'
);

-- 10. RESIDUO_CONSTITUYENTE
CREATE TABLE RESIDUO_CONSTITUYENTE (
    ResConsCod SERIAL PRIMARY KEY,
    ResCod INTEGER NOT NULL REFERENCES RESIDUO (ResCod),
    ConsCod INTEGER NOT NULL REFERENCES CONSTITUYENTE (ConsCod),
    ResConsPorc NUMERIC(5, 2),
    EstReg CHAR(1) NOT NULL DEFAULT 'A'
);

-- 11. TRASLADO_RESIDUO
CREATE TABLE TRASLADO_RESIDUO (
    TrasCod SERIAL PRIMARY KEY,
    TrasFec DATE NOT NULL,
    TrasCant NUMERIC(8, 2) NOT NULL,
    TrasDsc VARCHAR(250),
    ResCod INTEGER NOT NULL REFERENCES RESIDUO (ResCod),
    EmpCod INTEGER NOT NULL REFERENCES EMPRESA_PRODUCTORA (EmpCod),
    TrsEmpCod INTEGER NOT NULL REFERENCES EMPRESA_TRANSPORTISTA (TrsEmpCod),
    DestCod INTEGER NOT NULL REFERENCES DESTINO (DestCod),
    EstReg CHAR(1) NOT NULL DEFAULT 'A'
);