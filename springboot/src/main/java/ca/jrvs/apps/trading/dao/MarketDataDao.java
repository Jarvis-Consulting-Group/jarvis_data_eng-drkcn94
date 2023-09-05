package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.model.config.MarketDataConfig;
import ca.jrvs.apps.trading.model.domain.IexQuote;
import org.apache.http.conn.HttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class MarketDataDao implements CrudRepository<IexQuote, String> {

    private static final String IEX_BATCH_PATH = "/stock/market/batch?symbols=%s&types=quote&token=";
    private final String IEX_BATCH_URL;

    private Logger logger = LoggerFactory.getLogger(MarketDataDao.class);
    private HttpClientConnectionManager httpClientConnectionManager;

    @Autowired
    public MarketDataDao(HttpClientConnectionManager httpClientConnectionManager, MarketDataConfig marketDataConfig) {
        this.httpClientConnectionManager = httpClientConnectionManager;
        IEX_BATCH_URL = marketDataConfig.getHost() + IEX_BATCH_PATH + marketDataConfig.getToken();
    }

    @Override
    public <S extends IexQuote> S save(S entity) {
        return null;
    }

    @Override
    public <S extends IexQuote> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<IexQuote> findById(String ticker) {
        Optional<IexQuote> iexQuote;
        List<IexQuote> quotes = (List<IexQuote>) findAllById(Collections.singletonList(ticker));

        if(quotes.size() == 0) {
            return Optional.empty();
        }
        else if (quotes.size() == 1){
            iexQuote = Optional.of(quotes.get(0));
        }
        else {
            throw new DataRetrievalFailureException("Number of quotes returned is not typical");
        }
        return iexQuote;
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<IexQuote> findAll() {
        return null;
    }

    @Override
    public Iterable<IexQuote> findAllById(Iterable<String> tickers) {
        // convert iterable<string> to string of tickers separated by commas

        httpClientConnectionManager.connect(IEX_BATCH_URL,);

        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(IexQuote entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends IexQuote> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
