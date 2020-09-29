package com.scorp.loftcoin.data;

import androidx.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;

public interface WalletsRepo {

    @NonNull
    Observable<List<Wallet>> wallets(@NonNull Currency currency);

    @NonNull
    Observable<List<Transaction>> transaction(@NonNull Wallet wallet);

}