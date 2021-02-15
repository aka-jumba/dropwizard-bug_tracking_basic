package in.dreamplug.userservice.configuration;

public class DatabaseConfiguration {
    private String driverClass;
    private String user;
    private String password;
    private String url;
    private int acquireIncrement;
    private int initialPoolSize;
    private int minPoolSize;
    private int maxPoolSize;
    private int maxIdleTime;
    private int maxStatements;
    private int idleConnectionTestPeriod;
    private String testStatement;
    private String poolName;
    private int connectionTimeout = 3000;
    private int maxLifeTime = 1800000;
    private boolean autoCommit = true;
    private boolean readOnly = false;

    public String getDriverClass() {
        return this.driverClass;
    }

    public String getUser() {
        return this.user;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUrl() {
        return this.url;
    }

    public int getAcquireIncrement() {
        return this.acquireIncrement;
    }

    public int getInitialPoolSize() {
        return this.initialPoolSize;
    }

    public int getMinPoolSize() {
        return this.minPoolSize;
    }

    public int getMaxPoolSize() {
        return this.maxPoolSize;
    }

    public int getMaxIdleTime() {
        return this.maxIdleTime;
    }

    public int getMaxStatements() {
        return this.maxStatements;
    }

    public int getIdleConnectionTestPeriod() {
        return this.idleConnectionTestPeriod;
    }

    public String getTestStatement() {
        return this.testStatement;
    }

    public String getPoolName() {
        return this.poolName;
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public int getMaxLifeTime() {
        return this.maxLifeTime;
    }

    public boolean isAutoCommit() {
        return this.autoCommit;
    }

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setAcquireIncrement(int acquireIncrement) {
        this.acquireIncrement = acquireIncrement;
    }

    public void setInitialPoolSize(int initialPoolSize) {
        this.initialPoolSize = initialPoolSize;
    }

    public void setMinPoolSize(int minPoolSize) {
        this.minPoolSize = minPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public void setMaxIdleTime(int maxIdleTime) {
        this.maxIdleTime = maxIdleTime;
    }

    public void setMaxStatements(int maxStatements) {
        this.maxStatements = maxStatements;
    }

    public void setIdleConnectionTestPeriod(int idleConnectionTestPeriod) {
        this.idleConnectionTestPeriod = idleConnectionTestPeriod;
    }

    public void setTestStatement(String testStatement) {
        this.testStatement = testStatement;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public void setMaxLifeTime(int maxLifeTime) {
        this.maxLifeTime = maxLifeTime;
    }

    public void setAutoCommit(boolean autoCommit) {
        this.autoCommit = autoCommit;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public DatabaseConfiguration() {
    }
}
