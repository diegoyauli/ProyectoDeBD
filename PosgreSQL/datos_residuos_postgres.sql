-- ============================================
-- DATOS DE PRUEBA PARA LA BD ResiduosToxicos
-- Adaptado a PostgreSQL - Versión ampliada
-- ============================================

-- Tabla: REGION
INSERT INTO REGION (RegCod, RegNom) VALUES
(1, 'Lima'),
(2, 'Arequipa'),
(3, 'Cusco'),
(4, 'Piura'),
(5, 'Tacna');

-- Tabla: CODIGO_RESIDUO
INSERT INTO CODIGO_RESIDUO (CodResCod, CodResDesc) VALUES
('R001', 'Residuos químicos peligrosos'),
('R002', 'Residuos biológicos infecciosos'),
('R003', 'Residuos industriales no peligrosos'),
('R004', 'Aceites usados contaminados'),
('R005', 'Baterías de plomo ácido');

-- Tabla: EMPRESA_PRODUCTORA
INSERT INTO EMPRESA_PRODUCTORA (EmpNom, EmpRUC, EmpDir, EmpAct, RegCod) VALUES
('Químicos Industriales SAC', '12345678901', 'Av. Industrial 123', 'Fabricación de ácidos', 1),
('BioLab S.A.', '10987654321', 'Calle Científica 456', 'Laboratorio médico', 2),
('Metalúrgica del Sur', '20481234567', 'Zona Industrial Mz A', 'Fundición de metales', 3),
('EcoEmpresarial SAC', '10293847561', 'Av. Ambiental 888', 'Gestión de residuos', 4),
('Farmacia Nacional', '19876543210', 'Calle Salud 555', 'Producción farmacéutica', 5);

-- Tabla: EMPRESA_TRANSPORTISTA
INSERT INTO EMPRESA_TRANSPORTISTA (TrsNom, TrsRUC, TrsDir, TrsCap, RegCod) VALUES
('TransResiduos SAC', '11111111111', 'Av. Transporte 789', 5000.00, 1),
('EcoMovil SRL', '22222222222', 'Jr. Ecológico 321', 3000.00, 2),
('MovilClean', '33333333333', 'Calle Reciclaje 123', 4500.00, 3),
('Ambiente Cargo', '44444444444', 'Av. Sustentable 456', 6000.00, 4),
('GreenMove SAC', '55555555555', 'Pasaje Verde 321', 3500.00, 5);

-- Tabla: DESTINO
INSERT INTO DESTINO (DestNom, DestDir, DestCap, DestCapAct, RegCod) VALUES
('Planta Tratamiento Norte', 'Km 25 Carretera Central', 10000.00, 4500.00, 1),
('Relleno Sur', 'Sector B - Zona Sur', 8000.00, 7000.00, 2),
('Centro Recolección Cusco', 'Av. Andina 100', 6000.00, 4000.00, 3),
('Estación Piura Verde', 'Jr. Palmeras 900', 5000.00, 2000.00, 4),
('Planta Tacna Eco', 'Zona Frontera S/N', 7500.00, 5500.00, 5);

-- Tabla: CONSTITUYENTE
INSERT INTO CONSTITUYENTE (ConNom, ConDes, ConGrad) VALUES
('Mercurio', 'Metal pesado tóxico', 5),
('Formaldehído', 'Compuesto orgánico volátil', 3),
('Plomo', 'Metal tóxico acumulativo', 4),
('Fenol', 'Compuesto corrosivo', 2),
('Cadmio', 'Contaminante ambiental', 5);

-- Tabla: RESIDUO
INSERT INTO RESIDUO (ResNom, ResDes, CodResCod, EmpCod) VALUES
('Residuos de ácido sulfúrico', 'Alta corrosividad', 'R001', 1),
('Desechos biológicos de laboratorio', 'Potencial infectante', 'R002', 2),
('Lodos industriales', 'Contienen metales pesados', 'R003', 3),
('Aceite usado de motor', 'Contaminante por hidrocarburos', 'R004', 4),
('Baterías usadas de autos', 'Contienen plomo y ácido', 'R005', 5);

-- Tabla: RESIDUO_CONSTITUYENTE
INSERT INTO RESIDUO_CONSTITUYENTE (ResCod, ConsCod, ResConsPorc) VALUES
(1, 1, 70.5),
(2, 2, 50.0),
(3, 3, 65.0),
(4, 4, 40.0),
(5, 3, 80.0);

-- Tabla: TRASLADO_RESIDUO
INSERT INTO TRASLADO_RESIDUO (TrasFec, TrasCant, TrasDsc, ResCod, EmpCod, TrsEmpCod, DestCod) VALUES
('2025-06-28', 150.50, 'Traslado mensual de residuos químicos', 1, 1, 1, 1),
('2025-06-29', 80.00, 'Muestras biológicas', 2, 2, 2, 2),
('2025-07-01', 200.00, 'Transporte de lodos industriales', 3, 3, 3, 3),
('2025-07-02', 120.75, 'Aceites usados de flota', 4, 4, 4, 4),
('2025-07-03', 90.25, 'Baterías recogidas del sur', 5, 5, 5, 5);

