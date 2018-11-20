import { Estacion } from "./Estacion";
import { Consulta } from "./Consulta";

export class Respuesta {
    public tiempo: number;
	public consultaRealizada: Consulta;
	public estaciones: Estacion[];
}