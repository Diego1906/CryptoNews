package br.com.cryptonews.util

enum class QueryType(val value: String) {
    BITCOIN("bitcoin"),
    BITCOIN_CASH("bitcoin cash"),
    ETHEREUM("ethereum"),
    LITECOIN("litecoin"),
    RIPPLE("ripple"),
    SHOW_ALL("crypto")
}

enum class NewsApiStatus {
    LOADING,
    ERROR,
    DONE,
    NO_INTERNET_CONNECTION
}