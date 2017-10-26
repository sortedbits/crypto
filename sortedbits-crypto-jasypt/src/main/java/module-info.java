module com.sortedbits.crypto.jasypt {

    requires com.sortedbits.crypto.api;
    requires jasypt;
    provides com.sortedbits.crypto.api.PasswordEncryption with com.sortedbits.crypto.jasypt.JasyptPasswordEncryption;
}