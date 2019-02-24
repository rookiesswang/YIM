/**
 *  实现CICC结合 layui实现弹出框效果
 * Created by mr_yi on 2017/8/23.
 */
var layer;

var arry = ['确定', '取消'];
var arr = ['确定'];


layui.use('layer', function () {
    layer = layui.layer;
});
(function ($) {
    $.extend({
        cicc_messager: {
            /**
             * @param contentStr 内容展示
             * @param icontType 1 对,2 错 ,3 错, 4 锁 , 5 苦脸 6 笑脸 -1 不显示
             * @param fn 回调函数
             * @return layer  可调用 layer.closeAll()将其关闭;
             */
            alert: function (contentStr, icontType, fn) {
                var icon = typeof icontType === 'number' ? icontType : 6;
                layer.open({
                    type: 0,
                    title: ['', 'font-size:14px;background-color: #fff;color:#666;text-align:center;padding:0px;border-radius:5px;height: 10px;'],
                    content: contentStr,
                    area: ['500px'],
                    offset: '100px',
                    icon: icon,
                    btn: arr,
                    end: function () {
                        if (typeof fn === 'function') {
                            fn.call();
                        }
                    },
                    closeBtn: false,
                    anim: 4,
                    resize: false,
                    move: false,
                    scrollbar: false,
                    success: function (layero) {
                        layero.css({"border-radius": "10px", "text-align": "center"});
                        var content = layero.find('.layui-layer-content');
                        content.css({"display": "inline-block","color":"#666"});
                        var btn = layero.find('.layui-layer-btn');
                        btn.css({'padding': '15px 15px 12px'});
                        var btn0 = btn.find('.layui-layer-btn0');
                        btn0.css({
                        	'background-color': '#fff',
                            'color': '#d00000',
                            'font-size': '13px',
                            'border-radius': '5px',
                            'border': '1px solid #d00000'
                        });
                    }
                });
                return layer;
            },
            loading: function () {
                layer.open({
                    type: 3
                });
                return layer;
            },
            tips: function (contentStr, id) {
                layer.open({
                    type: 1,
                    content: [contentStr, '#' + id]
                });
                return layer;
            },
            /**
             * @param contentStr 内容展示
             * @param icontType 1 对,2 错 ,3 错, 4 锁 , 5 苦脸 6 笑脸 -1 不显示
             * @param fn 回调函数
             */
            confirm: function (contentStr, icontType, fn) {
                var icon = typeof icontType === 'number' ? icontType : 6;             
                layer.open({
                    type: 0,
                    title: ['', 'font-size:14px;background-color: #fff;color:#666;text-align:center;padding:0px;border-radius:5px;height: 10px;'],
                    content: contentStr,
                    area: ['500px'],
                    offset: '100px',
                    icon: icon,
                    btn: arry,
                    yes: function (index) {
                        layer.close(index);
                        if (typeof fn === 'function') {
                            fn.call();
                        }
                    },
                    no: function (index) {
                        layer.close(index);
                    },
                    closeBtn: false,
                    anim: 4,
                    resize: false,
                    move: false,
                    scrollbar: false,
                    success: function (layero) {
                        layero.css({"border-radius": "5px", "text-align": "center"});
                        var content = layero.find('.layui-layer-content');
                        content.css({"display": "inline-block","height":"auto"});
                        var btn = layero.find('.layui-layer-btn');
                        btn.css({'padding': '0px 15px 12px'});
                        var btn0 = btn.find('.layui-layer-btn0');
                        btn0.css({
                            'background-color': '#fff',
                            'color': '#d00000',
                            'font-size': '13px',
                            'border-radius': '5px',
                            'border': '1px solid #d00000',
                            'margin-right':'20px'
                        });
                        var btn1 = btn.find('.layui-layer-btn1');
                        btn1.css({
                            'font-size': '13px',
                            'background-color': '#FFF',
                            "color": "#666",
                            'border-radius': '5px',
                            'border': '1px solid #666'
                        });
                    }
                });
                return layer;
            }
        }
    });
    $.extend({
        isSet: function (str) {
            str = $.trim(str);
            if (str === null || str === '' || str === undefined) {
                return false;
            }
            return true;
        },
        str2UTF8: function (str) {
            var bytes = new Array();
            var len, c;
            len = str.length;
            for (var i = 0; i < len; i++) {
                c = str.charCodeAt(i);
                if (c >= 0x010000 && c <= 0x10FFFF) {
                    bytes.push(((c >> 18) & 0x07) | 0xF0);
                    bytes.push(((c >> 12) & 0x3F) | 0x80);
                    bytes.push(((c >> 6) & 0x3F) | 0x80);
                    bytes.push((c & 0x3F) | 0x80);
                } else if (c >= 0x000800 && c <= 0x00FFFF) {
                    bytes.push(((c >> 12) & 0x0F) | 0xE0);
                    bytes.push(((c >> 6) & 0x3F) | 0x80);
                    bytes.push((c & 0x3F) | 0x80);
                } else if (c >= 0x000080 && c <= 0x0007FF) {
                    bytes.push(((c >> 6) & 0x1F) | 0xC0);
                    bytes.push((c & 0x3F) | 0x80);
                } else {
                    bytes.push(c & 0xFF);
                }
            }
            return bytes;
        }
    });
}(window.jQuery));