package com.vale.javarx.service;

import com.vale.javarx.clientapi.NobelClientApi;


import com.vale.javarx.entity.LaureateInfo;
import com.vale.javarx.entity.NobelPrize;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class RxServiceImpl implements RxService{

    @Autowired
    private NobelClientApi nobelClientApi;

    @Override
    public Observable<LaureateInfo> getLaureatesByCategoryAndYear(String category, Integer year) {
        Observable<NobelPrize> observablePrize = nobelClientApi
                .getNobelByCategoryandYear(category, year)
                .flatMap(Observable::fromIterable);
        return observablePrize
                .flatMap(x -> Observable.fromIterable(x.getLaureates()))
                .flatMap(n->nobelClientApi.getLaureateInfo(n.getId()))
                .flatMap(Observable::fromIterable);
    }

    @Override
    public Observable<LaureateInfo> getLaureateById(Integer id) {

        return null;
    }
}
