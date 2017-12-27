package edu.coursera.concurrent;

import static edu.rice.pcdp.PCDP.isolated;

/**
 * A thread-safe transaction implementation using object-based isolation.
 */
public final class BankTransactionsUsingObjectIsolation
        extends ThreadSafeBankTransaction {
    /**
     * {@inheritDoc}
     */
    @Override
    public void issueTransfer(final int amount, final Account src,
            final Account dst) {
        isolated(src, dst, () -> {
            final boolean success = src.withdraw(amount);
            if(success) {
                dst.deposit(amount);
            }
        });
    }
}
