import com.sortedbits.crypto.none.NoPasswordEncryption;

module com.sortedbits.crypto.none {

    requires com.sortedbits.crypto.api;

    provides com.sortedbits.crypto.api.PasswordEncryption with NoPasswordEncryption;
}