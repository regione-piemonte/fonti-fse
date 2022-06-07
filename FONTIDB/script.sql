--                                                              --
--  SPDX-FileCopyrightText: (C) Copyright 2022 Regione Piemonte --
--                                                              --
--  SPDX-License-Identifier: EUPL-1.2                           --
--                                                              --

CREATE TABLE dmaccfonti_t_fonti_statiche (
	id_fonte_statica serial NOT NULL,
	codice_azienda varchar(20) NOT NULL,
	descrizione_azienda varchar(100) NULL,
	id_natura_azienda numeric(2) NOT NULL,
	codice_documento varchar(50) NOT NULL,
	descrizione_documento varchar(100) NULL,
	alimentazione_documento varchar(1) NOT NULL,
	CONSTRAINT "PK_dmaccfonti_t_fonti_statiche" PRIMARY KEY (id_fonte_statica)
);


CREATE TABLE dmaccfonti_t_fonti_da_dwh (
	id_fonte_dwh serial NOT NULL,
	codice_azienda varchar(20) NOT NULL,
	descrizione_azienda varchar(100) NULL,
	id_natura_azienda numeric(2) NOT NULL,
	codice_documento varchar(50) NOT NULL,
	descrizione_documento varchar(100) NULL,
	conteggio_documento numeric(20) NOT NULL,
	alimentazione_documento varchar(1) NOT NULL,
	data_inizio_validita timestamp NOT NULL,
	data_fine_validita timestamp NOT NULL,
	CONSTRAINT "PK_dmaccfonti_t_dwh" PRIMARY KEY (id_fonte_dwh)
);

CREATE TABLE dmaccfonti_t_aziende (
	azienda_codice int8 NOT NULL,
	azienda_descrizione varchar NOT NULL,
	natura_id int8 NOT NULL,
	natura_descrizione varchar NOT NULL
);

CREATE TABLE dmaccfonti_t_documenti (
	codice varchar NOT NULL,
	descrizione varchar NOT NULL
);


------
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(203, 'A.S.L. TORINO 3', 1, 'Pubblico');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(204, 'A.S.L. TORINO 4', 1, 'Pubblico');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(205, 'A.S.L. TORINO 5', 1, 'Pubblico');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(206, 'A.S.L. VERCELLI', 1, 'Pubblico');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(207, 'A.S.L. BIELLA', 1, 'Pubblico');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(208, 'A.S.L. NOVARA', 1, 'Pubblico');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(209, 'A.S.L. VERBANO-CUSIO-OSSOLA', 1, 'Pubblico');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(210, 'A.S.L. CUNEO 1', 1, 'Pubblico');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(211, 'A.S.L. CUNEO 2', 1, 'Pubblico');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(212, 'A.S.L. ASTI', 1, 'Pubblico');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(213, 'A.S.L. ALESSANDRIA', 1, 'Pubblico');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(301, 'A.S.L. CITTA'' DI TORINO', 1, 'Pubblico');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(603, 'CLINICA SANTA CATERINA DA SIENA s.r.l.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(604, 'CASA DI CURA "SEDES SAPIENTIAE"', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(610, 'CASA DI CURA FORNACA DISESSANT', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(611, 'VILLA MARIA PIA HOSPITAL', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(612, 'CASA DI CURA KOELLIKER OSPEDALINO', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(614, 'CASA DI CURA VILLE AUGUSTA - S.R.L.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(615, 'CASA DI CURA VILLA PATRIZIA - S.R.L.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(617, 'VILLE "TURINA AMIONE"', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(618, 'CASA DI CURA E RIPOSO S. LUCA S.P.A.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(621, 'CASA DI CURA VILLA SERENA - S.P.A.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(622, 'SANTA CROCE SRL', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(623, 'VILLA PAPA GIOVANNI XXIII', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(626, 'POLICLINICO DI MONZA S.P.A.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(627, 'CASA DI CURA SAN GIORGIO', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(629, 'CASA DI CURA L''EREMO DI MIAZZINA', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(630, 'CASA DI CURA S.CARLO DI ARONA', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(631, 'CASA DI CURA SAN MICHELE', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(632, 'CASA DI CURA CITTA'' DI BRA', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(633, 'ISTITUTO CLIMATICO DI ROBILANTE', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(634, 'CASA DI CURA MONTESERRAT S.R.L', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(635, 'CASA DI CURA "LA RESIDENZA"', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(639, 'CASA DI CURA S. ANNA SPA', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(641, 'CASA DI CURA VILLA IGEA', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(642, 'CASA DI CURA SANT''ANNA', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(644, 'VILLA GRAZIA', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(646, 'CASA DI CURA VILLA IRIS SRL', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(647, 'CASA DI CURA "STELLA DEL MATTINO"', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(648, 'CASA DI CURA VILLA ADRIANA', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(649, 'CASA DI CURA I CEDRI', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(651, 'CASA DI CURA MADONNA DEI BOSCHI', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(653, 'PROMEA S.P.A.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(655, 'CASA DI CURA CELLINI', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(657, 'CASA DI CURA CENTRO R.R.F. MONS. LUIGI NOVARESE', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(659, 'S.R.L. TERAPEUTICENTER - ISTITUTO MEDICO CHIRURGICO', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(660, 'CENTRO MEDICO POLISPECIALISTICO AMBULATORIALE SAN LUIGI', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(661, 'LISA - POLICLINICO SAN LUCA S.R.L.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(662, 'MOD CENTRO MEDICO CHIRURGICO', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(663, 'MEDICAL SERVICE S.A.S', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(664, 'LARC 2 s.r.l.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(665, 'CASA DI CURA VILLA CRISTINA', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(700, 'STUDIO MEDICO MIRAFIORI SRL-STR. BASSE', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(701, 'RAFFAELLO S.R.L.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(702, 'A.N.S.A. S.R.L.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(704, 'CHIROS S.R.L.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(705, 'CENTRO DIAGNOSTICO CERNAIA CERNAIA', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(706, 'FISIO SRL CENTRO MED. LINGOTTO', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(707, 'IST.FISICOTERAPICO DI TORINO', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(708, 'LARC Spa', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(709, 'PKT SRL', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(710, 'S.K.T. S.R.L. - STUDIO KINESITERAPICO TORINESE', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(711, 'I.F.O.R.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(712, 'L.A.M.A.T.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(713, 'PUNTO DE.GA. S.R.L.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(714, 'NUOVA LAMP S.R.L.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(715, 'STUDIO MEDICO FISIOTERAPICO S.R.L.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(716, 'INDAGINI RICERCHE MEDICHE', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(717, 'ISTITUTO MALPIGHI', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(718, 'POLIAMBULATORIO MEDICO CHIERESE', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(719, 'LABORATORIO MEDICO C. BATTISTI', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(720, 'CENTRO DIAGNOSTICO LA-RA SRL', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(721, 'DOC SERVICE FISIOKINESITERAPIA', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(722, 'PASTEUR LABORATORIO ANALISI CUNEO', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(723, 'CENTRO MEDICO ALBESE', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(724, 'ST."CENTOCANNONI" DI PIACENTINO', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(726, 'STUDIO DOTT.C. PONZANO SRL', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(727, 'STUDIO RADIOLOG. OMODEO ZORINI', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(728, 'AMBULATORIO RADIOLOGICO DR. FOCO S.A.S.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(729, 'STUDIO RADIOLOGICO NEWIMA S.R.L.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(730, 'CENTRO DIAGNOSTICO CIGLIANESE CIGLIANO', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(733, 'IMT- MEDIL S.P.A.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(735, 'R.I.B.A. S.P.A', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(736, 'LABORATORIO ANALISI S. MARIA DEL DR. W. QUAGLIA', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(737, 'IRMET S.P.A', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(738, 'C.F.T. KINETOS S.A.S DI BONOMO M. E C.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(741, 'COOPERATIVA MEDICINA ATTIVA', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(745, 'CENTRO DIAGNOSTICO BIELLESE', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(746, 'CENTRO FISIOTERAPIA STAGNO DI DAVIDE E STEFANO STAGNO SNC', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(800, 'BOGNANCO ACQUE MINERALI SRL', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(801, 'TERME DI VALDIERI SO.GE.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(802, 'TERME DI VINADIO', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(803, 'TERME DI LURISIA', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(805, 'STAB. TERMALE FONS SALUTIS', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(806, 'TERME DI ACQUI S.P.A.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(807, 'TERME PREMIA SRL VALLI ANTIGORIO DIVEDRO FORMAZZA', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(853, 'ISTITUTO SACRA FAMIGLIA', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(854, 'CENTRO DI RIABIL.G.FERRERO', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(855, 'ASS. CENTRI V.C.O. GRAVELLONA', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(856, 'ASS. CENTRI V.C.O. DOMODOSSOLA', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(857, 'CENTRO "PAOLO VI"', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(858, 'GIOVANNI XXIII SRL "CENTRO DON FRANCO PICCO"', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(859, 'DOMUS LAETITIAE SOC. COOP.SOCIALE DI SOLIDARIETA''', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(860, 'TERME REALI DI VALDIERI S.P.A', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(861, 'ALLIANCE MEDICAL DIAGNOSTIC SRL', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(862, 'OTIP', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(863, 'RETE VILLA IGEA E I CEDRI HOSPITAL', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(864, 'LEGA ITALIANA LOTTA CONTRO I TUMORI LILT', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(865, 'STUDIO MEDICO AURORA', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(866, 'BIOCHEMICAL SRL', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(868, 'CASA DI CURA HABILITA S.P.A.', 2, 'Privato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(904, 'AZIENDA OSP. S.LUIGI', 1, 'Pubblico');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(905, 'AZIENDA OSP. MAGGIORE DELLA CARITA''', 1, 'Pubblico');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(906, 'AZIENDA OSP. S.CROCE E CARLE', 1, 'Pubblico');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(907, 'AZIENDA OSP. S.ANTONIO BIAGIO/ARRIGO', 1, 'Pubblico');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(908, 'AZIENDA OSP. ORDINE MAURIZIANO DI TORINO', 1, 'Pubblico');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(909, 'AZIENDA OSP. CITTA DELLA SALUTE E DELLA SCIENZA DI TORINO', 1, 'Pubblico');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(920, 'ISTITUTO AUXOLOGICO ITALIANO', 3, 'Equiparato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(921, 'FONDAZIONE SALVATORE MAUGERI', 3, 'Equiparato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(922, 'IRCCS - ISTITUTO PER LA RICERCA E CURA DEL CANCRO', 3, 'Equiparato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(990, 'AUSILIATRICE', 3, 'Equiparato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(991, 'BEATA VERGINE DELLA CONSOLATA- FATEBENE FRATELLI', 3, 'Equiparato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(992, 'PRESIDIO SANITARIO GRADENIGO', 3, 'Equiparato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(993, 'SAN CAMILLO', 3, 'Equiparato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(996, 'PRESIDIO C.O.Q.', 3, 'Equiparato');
INSERT INTO dmaccfonti_t_aziende (azienda_codice, azienda_descrizione, natura_id, natura_descrizione) VALUES(997, 'PRESIDIO SANITARIO COTTOLENGO', 3, 'Equiparato');

--------
INSERT INTO dmaccfonti_t_documenti (codice, descrizione) VALUES('11502-2', 'REFERTO DI LABORATORIO');
INSERT INTO dmaccfonti_t_documenti (codice, descrizione) VALUES('68604-8', 'REFERTO DI RADIOLOGIA');
INSERT INTO dmaccfonti_t_documenti (codice, descrizione) VALUES('11526-1', 'REFERTO DI ANATOMIA PATOLOGICA');
INSERT INTO dmaccfonti_t_documenti (codice, descrizione) VALUES('11488-4', 'REFERTO SPECIALISTICO');
INSERT INTO dmaccfonti_t_documenti (codice, descrizione) VALUES('59258-4', 'VERBALE DI PRONTO SOCCORSO');
INSERT INTO dmaccfonti_t_documenti (codice, descrizione) VALUES('34105-7', 'LETTERA DI DIMISSIONE OSPEDALIERA');
INSERT INTO dmaccfonti_t_documenti (codice, descrizione) VALUES('ATTO_OPERATORIO', 'ATTO OPERATORIO');
INSERT INTO dmaccfonti_t_documenti (codice, descrizione) VALUES('SCREEN', 'ESITI SCREENING');
INSERT INTO dmaccfonti_t_documenti (codice, descrizione) VALUES('REG-82593-5', 'CERTIFICATO VACCINALE');
INSERT INTO dmaccfonti_t_documenti (codice, descrizione) VALUES('REG-87273-9', 'SCHEDA VACCINALE');


