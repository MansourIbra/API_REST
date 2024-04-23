package gn.orange.gestionetudiantv.Exception;

public enum ErreurCodes {
    ETUDIANT_NOT_FOUND(200),
    COURS_NOT_FOUND(100),
    INSCRIPTIONS_NOT_FOUND(50);
    private int code;
    ErreurCodes(int code )
    {
        this.code =code;
    }
    public int getCode()
    {
        return code;
    }
}
