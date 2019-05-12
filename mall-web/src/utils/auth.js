import Cookies from 'js-cookie'


/*
    token工具包
 */

const TokenKey = 'loginToken'

export function getToken() {
  return Cookies.get(TokenKey)
}

export function setToken(token) {
  return Cookies.set(TokenKey,token)
}

export function removeToken() {
  return Cookies.remove(TokenKey)
}


