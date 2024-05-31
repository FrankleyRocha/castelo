create table execucao (
    id uuid not null,
    fim timestamp(6),
    inicio timestamp(6),
    observacao varchar(255),
    tarefa_id uuid,
    primary key (id)
);

create table movimentacao (
    id uuid not null,
    momento timestamp(6),
    status_id uuid,
    status_anterior_id uuid,
    tarefa_id uuid,
    primary key (id)
);

create table status (
    id uuid not null,
    descricao varchar(255),
    nome varchar(255),
    titulo varchar(255),
    primary key (id)
);

create table tarefa (
    id uuid not null,
    indice number,
    descricao varchar(255),
    nome varchar(255),
    titulo varchar(255),
    status_id uuid,
    primary key (id)
);

alter table if exists execucao 
    add constraint FK1dkuu6hqjtq0oh3kwt3ft7wmh 
    foreign key (tarefa_id) 
    references tarefa;

alter table if exists movimentacao 
    add constraint FK9hcsvw6kvcsg2hgij40q0wbqv 
    foreign key (status_id) 
    references status;

alter table if exists movimentacao 
    add constraint FKvad816fx4r390kiismb6to06 
    foreign key (status_anterior_id) 
    references status;

alter table if exists movimentacao 
    add constraint FKf2j9ox8yubi09s62fwq79xogv 
    foreign key (tarefa_id) 
    references tarefa;

alter table if exists tarefa 
    add constraint FK6tsc6ls2trghg3pqmt99rh7b 
    foreign key (status_id) 
    references status;