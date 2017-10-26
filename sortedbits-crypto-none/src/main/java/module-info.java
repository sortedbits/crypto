module com.sortedbits.crypto.none {

    requires com.sortedbits.crypto.api;

    provides com.sortedbits.crypto.api.PasswordEncryption with com.sortedbits.crypto.none.NoPasswordEncryption;
}