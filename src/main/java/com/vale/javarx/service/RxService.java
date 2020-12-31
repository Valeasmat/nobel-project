package com.vale.javarx.service;

import com.vale.javarx.entity.LaureateInfo;
import com.vale.javarx.entity.NobelPrize;
import io.reactivex.Observable;


public interface RxService {
    public Observable<LaureateInfo> getLaureatesByCategoryAndYear(String category, Integer year);
    public Observable<LaureateInfo> getLaureateById(Integer id);
}
