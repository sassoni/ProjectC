package com.chaleva.sassoni.projectc.concertlist.model;

import com.chaleva.sassoni.projectc.Concert;

import java.util.List;

/**
 * Created by cchaleva on 3/30/16.
 */
public interface ConcertListProvider {

    List<Concert> loadConcerts();
}
