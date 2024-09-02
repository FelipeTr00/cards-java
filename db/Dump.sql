CREATE database eafc24;
USE eafc24;

CREATE TABLE pais (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    url_imagem VARCHAR(255)
);

CREATE TABLE carta (
    id INT PRIMARY KEY AUTO_INCREMENT,
    jogador VARCHAR(255) NOT NULL,
    conducao INT,
    ritmo INT,
    passes INT,
    fisico INT,
    defesa INT,
    finalizacao INT,
    posicao VARCHAR(3) NOT NULL,  -- Alterado para VARCHAR(3)
    id_nacionalidade INT,
    FOREIGN KEY (id_nacionalidade) REFERENCES pais(id)
);

CREATE TABLE posicao_jogador (
    id_jogador INT,
    ds_posicao VARCHAR(3) NOT NULL, -- Alterado para VARCHAR(3)
    FOREIGN KEY (id_jogador) REFERENCES carta(id),
    PRIMARY KEY (id_jogador, ds_posicao)
);


INSERT INTO pais (id, nome, url_imagem) VALUES
(1, 'Argentina', 'https://exemplo.com/bandeira-argentina.jpg'),
(2,' Brasil', 'https://exemplo.com/bandeira-brasil.jpg'),
(3, 'França', 'https://exemplo.com/bandeira-franca.jpg'),
(4, 'Portugal', 'https://exemplo.com/bandeira-portugal.jpg'),
(5, 'Alemanha', 'https://exemplo.com/bandeira-alemanha.jpg'),
(6, 'Espanha', 'https://exemplo.com/bandeira-espanha.jpg'),
(7, 'Inglaterra', 'https://exemplo.com/bandeira-inglaterra.jpg'),
(8, 'Itália', 'https://exemplo.com/bandeira-italia.jpg'),
(9, 'Países Baixos', 'https://exemplo.com/bandeira-paisesbaixos.jpg'),
(10, 'Bélgica', 'https://exemplo.com/bandeira-belgica.jpg');

INSERT INTO carta (jogador, conducao, ritmo, passes, fisico, defesa, finalizacao, posicao, id_nacionalidade) VALUES
('Lionel Messi', 96, 85, 92, 65, 34, 90, 'ATA', 1),
('Neymar Jr.', 95, 91, 86, 63, 32, 85, 'ATA', 2), 
('Kylian Mbappé', 92, 97, 84, 73, 39, 91, 'ATA', 3),
('Cristiano Ronaldo', 88, 87, 81, 75, 34, 93, 'ATA', 4), 
('Robert Lewandowski', 85, 78, 79, 82, 44, 92, 'CA', 5),
('Kevin De Bruyne', 91, 76, 93, 72, 64, 82, 'MC', 10), 
('Virgil van Dijk', 81, 78, 79, 92, 90, 62, 'ZAG', 9);


INSERT INTO posicao_jogador (id_jogador, ds_posicao) VALUES
(1, 'PD'),
(1, 'CAM'), 
(2, 'CAM'),
(3, 'PE'),
(4, 'PE'),
(4, 'CA'),
(5, 'ATA'),
(6, 'CAM'),
(7, 'VOL');


