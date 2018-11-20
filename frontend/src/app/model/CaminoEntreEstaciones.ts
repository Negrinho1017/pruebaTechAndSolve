import { Estacion } from "./Estacion";

export class CaminoEntreEstaciones {
    public id: String;
    public source: Estacion;
    public destination: Estacion;
    public weight: number;
}