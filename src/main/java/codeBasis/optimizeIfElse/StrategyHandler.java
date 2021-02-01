package codeBasis.optimizeIfElse;

/**
 * @author huangtengfei
 * @description
 * @time 2021/1/26 10:42
 */
public interface StrategyHandler<T, R> {
    @SuppressWarnings("rawtypes")
    StrategyHandler DEFAULT = t -> null;

    /**
     * apply strategy
     *
     * @param param
     * @return
     */
    R apply(T param);
}