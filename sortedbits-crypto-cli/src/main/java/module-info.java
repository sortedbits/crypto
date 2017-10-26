module com.sortedbits.crypto.cli {

    requires com.sortedbits.crypto.api;
    requires text.io;
    uses com.sortedbits.crypto.api.PasswordEncryption;
    exports com.sortedbits.crypto.cli;
}