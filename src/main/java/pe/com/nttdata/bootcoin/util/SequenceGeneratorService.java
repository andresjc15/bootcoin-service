package pe.com.nttdata.bootcoin.util;

import java.util.concurrent.ExecutionException;

public interface SequenceGeneratorService {

    long generateSequence(final String sequenceName) throws ExecutionException, InterruptedException;

}
