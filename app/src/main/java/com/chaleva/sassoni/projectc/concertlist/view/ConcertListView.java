package com.chaleva.sassoni.projectc.concertlist.view;

import com.chaleva.sassoni.projectc.Concert;

import java.util.List;

/**
 * Created by cchaleva on 3/30/16.
 */
public interface ConcertListView {

    void refreshConcertList(List<Concert> concerts);
}
