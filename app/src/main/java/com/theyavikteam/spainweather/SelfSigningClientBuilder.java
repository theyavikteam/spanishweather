package com.theyavikteam.spainweather;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import okhttp3.OkHttpClient;

public class SelfSigningClientBuilder {

    public static OkHttpClient createClient(Context context, OkHttpClient.Builder clientBuilder) {

        OkHttpClient client = null;

        CertificateFactory cf = null;
        InputStream cert = null;
        Certificate ca = null;
        SSLContext sslContext = null;
        try {
            cf = CertificateFactory.getInstance("X.509");
            cert = context.getResources().openRawResource(R.raw.aemetes);

            ca = cf.generateCertificate(cert);
            cert.close();

            String keyStoreType = KeyStore.getDefaultType();
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca", ca);

            String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
            tmf.init(keyStore);

            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);

            client = clientBuilder
                    .sslSocketFactory(sslContext.getSocketFactory())
                    .build();

        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException | KeyManagementException e) {
            e.printStackTrace();
        }

        return client;
    }

}