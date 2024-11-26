package br.com.fiap.Alertas.model;

public enum UsuarioRole {
    //Nessa linha abaixo criamos os perfis de permissões (usuario Admin, usuario Comum)
    ADMIN("admin"),
    USER("user");

    private String role;

    UsuarioRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}