import { Status } from "./status";

export class Tarefa {
    id?: string | undefined;
    indice!: number;
    nome!: string;
    titulo!: string;
    descricao?: string | undefined;
    status!: Status;
}