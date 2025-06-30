-- ============================================
-- DATOS DE PRUEBA PARA LA BD ResiduosToxicos
-- Adaptado a PostgreSQL
-- ============================================

-- Tabla: REGION
INSERT INTO REGION (RegCod, RegNom) VALUES
(1, 'Lima'),
(2, 'Arequipa');

-- Tabla: CODIGO_RESIDUO
INSERT INTO CODIGO_RESIDUO (CodResCod, CodResDesc) VALUES
('R001', 'Residuos químicos peligrosos'),
('R002', 'Residuos biológicos infecciosos');

-- Tabla: EMPRESA_PRODUCTORA
INSERT INTO EMPRESA_PRODUCTORA (EmpNom, EmpRUC, EmpDir, EmpAct, RegCod) VALUES
('Químicos Industriales SAC', '12345678901', 'Av. Industrial 123', 'Fabricación de ácidos', 1),
('BioLab S.A.', '10987654321', 'Calle Científica 456', 'Laboratorio médico', 2);

-- Tabla: EMPRESA_TRANSPORTISTA
INSERT INTO EMPRESA_TRANSPORTISTA (TrsNom, TrsRUC, TrsDir, TrsCap, RegCod) VALUES
('TransResiduos SAC', '11111111111', 'Av. Transporte 789', 5000.00, 1),
('EcoMovil SRL', '22222222222', 'Jr. Ecológico 321', 3000.00, 2);

-- Tabla: DESTINO
INSERT INTO DESTINO (DestNom, DestDir, DestCap, DestCapAct, RegCod) VALUES
('Planta Tratamiento Norte', 'Km 25 Carretera Central', 10000.00, 4500.00, 1),
('Relleno Sur', 'Sector B - Zona Sur', 8000.00, 7000.00, 2);

-- Tabla: CONSTITUYENTE
INSERT INTO CONSTITUYENTE (ConNom, ConDes, ConGrad) VALUES
('Mercurio', 'Metal pesado tóxico', 5),
('Formaldehído', 'Compuesto orgánico volátil', 3);

-- Tabla: RESIDUO
INSERT INTO RESIDUO (ResNom, ResDes, CodResCod, EmpCod) VALUES
('Residuos de ácido sulfúrico', 'Alta corrosividad', 'R001', 1),
('Desechos biológicos de laboratorio', 'Potencial infectante', 'R002', 2);

-- Tabla: RESIDUO_CONSTITUYENTE
INSERT INTO RESIDUO_CONSTITUYENTE (ResCod, ConsCod, ResConsPorc) VALUES
(1, 1, 70.5),  -- Residuos de ácido sulfúrico -> Mercurio
(2, 2, 50.0);  -- Desechos biológicos -> Formaldehído

-- Tabla: TRASLADO_RESIDUO
INSERT INTO TRASLADO_RESIDUO (TrasFec, TrasCant, TrasDsc, ResCod, EmpCod, TrsEmpCod, DestCod) VALUES
('2025-06-28', 150.50, 'Traslado mensual de residuos químicos', 1, 1, 1, 1),
('2025-06-29', 80.00, 'Muestras biológicas', 2, 2, 2, 2);

