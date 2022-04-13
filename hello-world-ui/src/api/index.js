import request from '@/utils/request'

export default {
  // 生成普通的二维码
  getQRCode () {
    return request({
      url: `/getQRCode`,
      method: 'get'
    })
  },
  // 生成带有logo的二维码
  getQRCodeAndLogo (query) {
    return request({
      url: `/getQRCodeAndLogo`,
      method: 'post',
      data: query
    })
  }

}
