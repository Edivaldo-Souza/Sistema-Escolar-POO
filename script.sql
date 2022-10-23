create database bd_sisescolar;

use bd_sisescolar;
create table tabela_aluno(
	matricula varchar(15) primary key,
    nome varchar(30)
);

create table tabela_professor(
	cpf varchar(15) primary key,
    nome varchar(30)
);

create table tabela_endereco_aluno(
    rua varchar(30),
    bairro varchar(30),
    numero int,
    mat_aluno varchar(15) references tabela_aluno(matricula)
);

create table tabela_endereco_professor(
    rua varchar(30),
    bairro varchar(30),
    numero int,
    cpf_prof varchar(15) references tabela_professor(cpf)
);

create table tabela_disciplina(
	codigo varchar(30) primary key,
    nome varchar(30)
);

create table turma(
	id int primary key,
    codigoDisciplina varchar(30) references tabela_disciplina(codigo),
    codigoProfessor varchar(15) references tabela_professor(cpf),
    horario varchar(30),
    local varchar(30),
    status boolean
);

create table tabela_resultadoTurma(
	cod_disciplina varchar(30) references tabela_disciplina(codigo),
    nota1 float,
    nota2 float,
    nota3 float,
    media float,
    frequencia float,
    mat_aluno varchar(15) references tabela_aluno(matricula)
);