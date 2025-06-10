public class Cep {
    long cep;
    String logradouro;
    String bairro;
    String estado;


    public Cep(RecordCep recordCep) {
        this.cep = Long.parseLong(recordCep.cep().replace("-", ""));
        this.logradouro = recordCep.logradouro();
        this.bairro = recordCep.bairro();
        this.estado = recordCep.estado();
    }

    @Override
    public String toString() {
        return "********\n" +
                "Cep: " + cep +
                "\nLogradouro: " + logradouro+
                "\nBairro: " + bairro+
                "\nEstado: " + estado +
                "\n********";
    }

    public long getCep() {
        return cep;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public String getBairro() {
        return bairro;
    }
    public String getEstado() {
        return estado;
    }

}



