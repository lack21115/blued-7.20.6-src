package com.bytedance.applog.util;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.applog.util.WebViewJsUtil;
import com.bytedance.bdtracker.b;
import com.bytedance.bdtracker.c;
import com.bytedance.bdtracker.j1;
import com.bytedance.bdtracker.k2;
import com.bytedance.bdtracker.z1;
import com.bytedance.bdtracker.z2;
import com.tencent.smtt.sdk.ValueCallback;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/util/WebViewJsUtil.class */
public class WebViewJsUtil {
    public static final String BUNDLE_WEB_INFO = "web_info";
    public static final String JS_CODE_COLLECT = "!function(){\"use strict\";function t(t,e){if(!(t instanceof e))throw new TypeError(\"Cannot call a class as a function\")}function e(t,e){for(var n=0;n<e.length;n++){var r=e[n];r.enumerable=r.enumerable||!1,r.configurable=!0,\"value\"in r&&(r.writable=!0),Object.defineProperty(t,r.key,r)}}function n(t,n,r){return n&&e(t.prototype,n),r&&e(t,r),t}function r(t,e){if(\"function\"!=typeof e&&null!==e)throw new TypeError(\"Super expression must either be null or a function\");t.prototype=Object.create(e&&e.prototype,{constructor:{value:t,writable:!0,configurable:!0}}),e&&a(t,e)}function i(t){return(i=Object.setPrototypeOf?Object.getPrototypeOf:function(t){return t.__proto__||Object.getPrototypeOf(t)})(t)}function a(t,e){return(a=Object.setPrototypeOf||function(t,e){return t.__proto__=e,t})(t,e)}function o(t,e){if(e&&(\"object\"==typeof e||\"function\"==typeof e))return e;return function(t){if(void 0===t)throw new ReferenceError(\"this hasn't been initialised - super() hasn't been called\");return t}(t)}function u(t){var e=function(){if(\"undefined\"==typeof Reflect||!Reflect.construct)return!1;if(Reflect.construct.sham)return!1;if(\"function\"==typeof Proxy)return!0;try{return Date.prototype.toString.call(Reflect.construct(Date,[],(function(){}))),!0}catch(t){return!1}}();return function(){var n,r=i(t);if(e){var a=i(this).constructor;n=Reflect.construct(r,arguments,a)}else n=r.apply(this,arguments);return o(this,n)}}function c(t,e,n){return(c=\"undefined\"!=typeof Reflect&&Reflect.get?Reflect.get:function(t,e,n){var r=function(t,e){for(;!Object.prototype.hasOwnProperty.call(t,e)&&null!==(t=i(t)););return t}(t,e);if(!r)return;var a=Object.getOwnPropertyDescriptor(r,e);if(a.get)return a.get.call(n);return a.value})(t,e,n||t)}function s(t){if([\"LI\",\"TR\",\"DL\"].includes(t.nodeName))return!0;if(t.dataset&&t.dataset.hasOwnProperty(\"teaIdx\"))return!0;if(t.hasAttribute&&t.hasAttribute(\"data-tea-idx\"))return!0;return!1}function l(t){if(!t)return!1;if([\"A\",\"BUTTON\"].includes(t.nodeName))return!0;if(t.dataset&&t.dataset.hasOwnProperty(\"teaContainer\"))return!0;if(t.hasAttribute&&t.hasAttribute(\"data-tea-container\"))return!0;return!1}function h(t){for(var e=t;e&&!l(e);){if(\"HTML\"===e.nodeName||\"BODY\"===e.nodeName)return t;e=e.parentElement}return e||t}function f(t){for(var e=[];null!==t.parentElement;)e.push(t),t=t.parentElement;var n=[],r=[];return e.forEach((function(t){var e=function(t){if(null===t)return{str:\"\",index:0};var e=0,n=t.parentElement;if(n)for(var r=0;r<n.children.length&&n.children[r]!==t;r++)n.children[r].nodeName===t.nodeName&&e++;return{str:[t.nodeName.toLowerCase(),s(t)?\"[]\":\"\"].join(\"\"),index:e}}(t),i=e.str,a=e.index;n.unshift(i),r.unshift(a)})),{element_path:\"/\".concat(n.join(\"/\")),positions:r}}function d(t){var e={element_path:\"\",positions:[],texts:[]},n=f(t),r=n.element_path,i=n.positions,a=function(t){var e=h(t),n=[];return!function t(e){var r=function(t){var e=\"\";return 3===t.nodeType?e=t.textContent.trim():t.dataset&&t.dataset.hasOwnProperty(\"teaTitle\")||t.hasAttribute(\"data-tea-title\")?e=t.getAttribute(\"data-tea-title\"):t.hasAttribute(\"title\")?e=t.getAttribute(\"title\"):\"INPUT\"===t.nodeName&&[\"button\",\"submit\"].includes(t.getAttribute(\"type\"))?e=t.getAttribute(\"value\"):\"IMG\"===t.nodeName&&t.getAttribute(\"alt\")&&(e=t.getAttribute(\"alt\")),e.slice(0,200)}(e);if(r&&-1===n.indexOf(r)&&n.push(r),e.childNodes.length>0)for(var i=e.childNodes,a=0;a<i.length;a++)8!==i[a].nodeType&&t(i[a])}(e),n}(t);e.element_path=r,e.positions=i.map((function(t){return\"\".concat(t)})),e.texts=a;var o=h(t);if(\"A\"===o.tagName&&(e.href=o.getAttribute(\"href\")),\"IMG\"===t.tagName){var u=t.getAttribute(\"src\");u&&0===u.trim().indexOf(\"data:\")&&(u=\"\"),e.src=u}return e.page_title=document.title,e.element_id=t.id,e.element_type=t.tagName,e}var p=function(){function e(n,r){var i=this;t(this,e),this.handler=function(t){var e=(t=i.getEvent(t)).target;if(!i.checkShouldTrackElement(e)||i.checkShouldIgnore(e))return;var n=i.getPositionData(e),r=i.getEventData(t,n),a=i.getElementData(e),o=i.getAllData(r,a,{element_width:Math.floor(n.element_width),element_height:Math.floor(n.element_height)});i.report(o)},this.info=n,this.autoTrack=r,this.listen()}return n(e,[{key:\"listen\",value:function(){this.autoTrack.root.addEventListener(this.info.eventType,this.handler,!0)}},{key:\"_checkShouldTrackElement\",value:function(t){return function(t){var e=window.innerHeight,n=window.innerWidth;if(1!==t.nodeType)return!1;if(function(t){for(var e=t.parentElement,n=!1;e;)\"svg\"===e.tagName.toLowerCase()?(e=null,n=!0):e=e.parentElement;return n}(t))return!1;if([\"HTML\",\"BODY\"].includes(t.tagName.toUpperCase()))return!1;var r=t;if(\"none\"===r.style.display)return!1;if(l(r))return!0;if(!function(t){if(t.children.length>0){var e=t.children;if([].slice.call(e).some((function(t){return t.children.length>0})))return!1;return!0}return!0}(r))return!1;if(r.clientHeight*r.clientWidth>.5*e*n)return!1;return!0}(t)}},{key:\"checkShouldTrackElement\",value:function(t){return!0}},{key:\"checkShouldIgnore\",value:function(t){return function(t){for(var e=t;e&&e.parentNode;){if(e.hasAttribute(\"data-tea-ignore\"))return!0;if(\"HTML\"===e.nodeName||\"body\"===e.nodeName)return!1;e=e.parentNode}return!1}(t)}},{key:\"getEvent\",value:function(t){return t}},{key:\"getEventData\",value:function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{},e=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{},n=t.clientX,r=t.clientY,i=e.left,a=e.top;return{touch_x:Math.floor(n-i),touch_y:Math.floor(r-a)}}},{key:\"getElementData\",value:function(t){return d(t)}},{key:\"getPositionData\",value:function(t){if(!t)return;var e=t.getBoundingClientRect(),n=e.width,r=e.height;return{left:e.left,top:e.top,element_width:n,element_height:r}}},{key:\"getAllData\",value:function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{},e=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{},n=arguments.length>2&&void 0!==arguments[2]?arguments[2]:{};return Object.assign(Object.assign(Object.assign(Object.assign({},t),e),n),{is_html:1,page_key:window.location.href})}},{key:\"report\",value:function(t){this.autoTrack.report(this.info.eventName,t)}},{key:\"destroy\",value:function(){this.autoTrack.root.removeEventListener(this.info.eventName,this.handler,!0),this.autoTrack=null}}]),e}(),v=function(e){r(o,e);var a=u(o);function o(e){var n;t(this,o),(n=a.call(this,{eventName:\"bav2b_page\"},e)).handler=function(t){if(n.checkHref())return;n._handler()},n._handler=function(){n.setHref();var t=n.getAllData();n.report(t)},n._listen();try{\"loading\"===document.readyState?document.addEventListener(\"DOMContentLoaded\",n._handler):setTimeout(n._handler)}catch(t){}return n}return n(o,[{key:\"listen\",value:function(){}},{key:\"_listen\",value:function(){var t=this;this._oldPushState=history.pushState,this._oldReplaceState=history.replaceState,history.pushState=function(){try{for(var e,n=arguments.length,r=new Array(n),i=0;i<n;i++)r[i]=arguments[i];return(e=t._oldPushState).call.apply(e,[history].concat(r))}finally{t._handler()}},history.replaceState=function(){try{for(var e,n=arguments.length,r=new Array(n),i=0;i<n;i++)r[i]=arguments[i];return(e=t._oldReplaceState).call.apply(e,[history].concat(r))}finally{t._handler()}},window.addEventListener(\"hashchange\",this.handler,!0),window.addEventListener(\"popstate\",this.handler,!0)}},{key:\"setHref\",value:function(t){this._currentHref=t||window.location.href}},{key:\"checkHref\",value:function(){return this._currentHref===window.location.href}},{key:\"getAllData\",value:function(){return Object.assign(Object.assign({},c(i(o.prototype),\"getAllData\",this).call(this)),{is_bav:1,page_key:this._currentHref,refer_page_key:document.referrer,page_title:document.title,page_path:this._currentHref,referrer_page_path:document.referrer})}},{key:\"destroy\",value:function(){window.removeEventListener(\"popstate\",this.handler,!0),window.removeEventListener(\"hashchange\",this.handler,!0),history.pushState=this._oldPushState,history.replaceState=this._oldReplaceState,this._oldPushState=null,this._oldReplaceState=null,this.autoTrack=null}}]),o}(p),g=function(e){r(o,e);var a=u(o);function o(e){return t(this,o),a.call(this,{eventType:\"click\",eventName:\"bav2b_click\"},e)}return n(o,[{key:\"checkShouldTrackElement\",value:function(t){return c(i(o.prototype),\"_checkShouldTrackElement\",this).call(this,t)}}]),o}(p),y=function(e){r(o,e);var a=u(o);function o(e){var n;return t(this,o),(n=a.call(this,{eventName:\"bav2b_click\"},e)).startHandler=function(t){var e=n.autoTrack.root,r=!1,i=function(){r=!0};e.addEventListener(\"touchmove\",i,!0),e.addEventListener(\"touchend\",(function t(a){r||n.handler(a),e.removeEventListener(\"touchmove\",i,!0),e.removeEventListener(\"touchend\",t,!0)}),!0)},n._listen(),n}return n(o,[{key:\"listen\",value:function(){}},{key:\"_listen\",value:function(){this.autoTrack.root.addEventListener(\"touchstart\",this.startHandler,!0)}},{key:\"getEvent\",value:function(t){return t.changedTouches[0]}},{key:\"checkShouldTrackElement\",value:function(t){if(!c(i(o.prototype),\"_checkShouldTrackElement\",this).call(this,t))return!1;if(\"input\"===t.nodeName.toLowerCase()&&[\"text\",\"password\",\"email\",\"tel\",\"number\",\"url\"].includes(t.type))return!1;return!0}},{key:\"destroy\",value:function(){this.autoTrack.root.removeEventListener(\"touchstart\",this.startHandler,!0),this.autoTrack=null}}]),o}(p),m=function(){function e(){t(this,e),this.version=\"1.2.1\",this.options={page:!1,touch:!1,click:!1},this.root=document,this.eventInstances=[],this.started=!1}return n(e,[{key:\"init\",value:function(t,e){this.options=Object.assign(Object.assign({},this.options),t),this.reportAdapter=e}},{key:\"start\",value:function(){if(this.started)return;this.started=!0;var t=this.options,e=t.page,n=t.click,r=t.touch;e&&this.eventInstances.push(new v(this)),n&&this.eventInstances.push(new g(this)),r&&this.eventInstances.push(new y(this))}},{key:\"stop\",value:function(){this.started=!1,this.eventInstances.forEach((function(t){return t.destroy()})),this.root=null}},{key:\"report\",value:function(){this.reportAdapter&&this.reportAdapter.apply(this,arguments)}}],[{key:\"getInstance\",value:function(){return e.instance||(e.instance=new e),e.instance}}]),e}();m.instance=null;var w,k,_;if(console.log(\"Winter Is Coming!\"),!window.TEAWebviewAutoTrack){var b=null,E=function(t){b||(b=window.TEANativeReport&&\"function\"==typeof window.TEANativeReport.postMessage?function(t){window.TEANativeReport.postMessage(t)}:window.TEANativeReport&&\"function\"==typeof window.TEANativeReport?function(t){window.TEANativeReport(t)}:window.webkit&&window.webkit.messageHandlers&&window.webkit.messageHandlers.TEANativeReport&&\"function\"==typeof window.webkit.messageHandlers.TEANativeReport.postMessage?function(t){window.webkit.messageHandlers.TEANativeReport.postMessage(t)}:function(t){}),b(t)},T=(w={page:!0,touch:!0,click:!1},k=function(){for(var t=arguments.length,e=new Array(t),n=0;n<t;n++)e[n]=arguments[n];var r=e[0],i=e[1],a=[{event:r,is_bav:1,local_time_ms:+new Date,params:i}];console.log(a[0]),E(JSON.stringify(a))},(_=m.getInstance()).init(w,k),_);T.start(),window.TEAWebviewAutoTrack=T}}();";
    public static final String JS_CODE_MARQUEE = "!function(){\"use strict\";function t(t){return function(t){if(Array.isArray(t))return e(t)}(t)||function(t){if(\"undefined\"!=typeof Symbol&&Symbol.iterator in Object(t))return Array.from(t)}(t)||function(t,n){if(!t)return;if(\"string\"==typeof t)return e(t,n);var r=Object.prototype.toString.call(t).slice(8,-1);\"Object\"===r&&t.constructor&&(r=t.constructor.name);if(\"Map\"===r||\"Set\"===r)return Array.from(t);if(\"Arguments\"===r||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(r))return e(t,n)}(t)||function(){throw new TypeError(\"Invalid attempt to spread non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.\")}()}function e(t,e){(null==e||e>t.length)&&(e=t.length);for(var n=0,r=new Array(e);n<e;n++)r[n]=t[n];return r}function n(t){if([\"LI\",\"TR\",\"DL\"].includes(t.nodeName))return!0;if(t.dataset&&t.dataset.hasOwnProperty(\"teaIdx\"))return!0;if(t.hasAttribute&&t.hasAttribute(\"data-tea-idx\"))return!0;return!1}function r(t){if(!t)return!1;if([\"A\",\"BUTTON\"].includes(t.nodeName))return!0;if(t.dataset&&t.dataset.hasOwnProperty(\"teaContainer\"))return!0;if(t.hasAttribute&&t.hasAttribute(\"data-tea-container\"))return!0;return!1}function i(t){for(var e=t;e&&!r(e);){if(\"HTML\"===e.nodeName||\"BODY\"===e.nodeName)return t;e=e.parentElement}return e||t}function o(t){for(var e=[];null!==t.parentElement;)e.push(t),t=t.parentElement;var r=[],i=[];return e.forEach((function(t){var e=function(t){if(null===t)return{str:\"\",index:0};var e=0,r=t.parentElement;if(r)for(var i=0;i<r.children.length&&r.children[i]!==t;i++)r.children[i].nodeName===t.nodeName&&e++;return{str:[t.nodeName.toLowerCase(),n(t)?\"[]\":\"\"].join(\"\"),index:e}}(t),o=e.str,a=e.index;r.unshift(o),i.unshift(a)})),{element_path:\"/\".concat(r.join(\"/\")),positions:i}}function a(t){var e={element_path:\"\",positions:[],texts:[]},n=o(t),r=n.element_path,a=n.positions,u=function(t){var e=i(t),n=[];return!function t(e){var r=function(t){var e=\"\";return 3===t.nodeType?e=t.textContent.trim():t.dataset&&t.dataset.hasOwnProperty(\"teaTitle\")||t.hasAttribute(\"data-tea-title\")?e=t.getAttribute(\"data-tea-title\"):t.hasAttribute(\"title\")?e=t.getAttribute(\"title\"):\"INPUT\"===t.nodeName&&[\"button\",\"submit\"].includes(t.getAttribute(\"type\"))?e=t.getAttribute(\"value\"):\"IMG\"===t.nodeName&&t.getAttribute(\"alt\")&&(e=t.getAttribute(\"alt\")),e.slice(0,200)}(e);if(r&&-1===n.indexOf(r)&&n.push(r),e.childNodes.length>0)for(var i=e.childNodes,o=0;o<i.length;o++)8!==i[o].nodeType&&t(i[o])}(e),n}(t);e.element_path=r,e.positions=a.map((function(t){return\"\".concat(t)})),e.texts=u;var c=i(t);if(\"A\"===c.tagName&&(e.href=c.getAttribute(\"href\")),\"IMG\"===t.tagName){var l=t.getAttribute(\"src\");l&&0===l.trim().indexOf(\"data:\")&&(l=\"\"),e.src=l}return e.page_title=document.title,e.element_id=t.id,e.element_type=t.tagName,e}var u=window.__TEA_CHUNK_MAX__||524288;function c(t){try{return new Blob([t]).size}catch(i){for(var e=t.length,n=e-1;n>=0;n--){var r=t.charCodeAt(n);r>127&&r<=2047?e++:r>2047&&r<=65535&&(e+=2),r>=56320&&r<=57343&&n--}return e}}function l(t){if(c(t)<u)return[t];var e=encodeURIComponent(t),n=Math.ceil(c(e)/u);return new Array(n).fill(\"\").map((function(t,n){return e.substr(n*u,u)}))}var f=function(t){var e=a(t),n=e.element_path,r=e.positions,i=e.texts,o=e.href,u=e.src,c=function(t,e){var n={};for(var r in t)Object.prototype.hasOwnProperty.call(t,r)&&e.indexOf(r)<0&&(n[r]=t[r]);if(null!=t&&\"function\"==typeof Object.getOwnPropertySymbols){var i=0;for(r=Object.getOwnPropertySymbols(t);i<r.length;i++)e.indexOf(r[i])<0&&Object.prototype.propertyIsEnumerable.call(t,r[i])&&(n[r[i]]=t[r[i]])}return n}(e,[\"element_path\",\"positions\",\"texts\",\"href\",\"src\"]),l=[].concat(r).reverse(),f=!1;if(-1!==n.indexOf(\"[]\")){f=!0;var s=!1;n.split(\"/\").reverse().forEach((function(t,e){s||-1===t.indexOf(\"[]\")||(s=!0,l[e]=\"*\")}))}var d=[\"absolute\",\"fixed\"],h=0,p=getComputedStyle(t,null).getPropertyValue(\"z-index\");\"auto\"!==p&&(h=parseInt(String(p),10));for(var m=t.parentElement;m;){var g=getComputedStyle(m,null);if(d.includes(g.getPropertyValue(\"position\"))){h+=1e4;break}m=m.parentElement}return Object.assign(Object.assign(Object.assign(Object.assign(Object.assign({},c),{_element_path:n,element_path:\"\".concat(n,\"/*\"),positions:r.concat(\"*\"),zIndex:h,texts:i}),f?{fuzzy_positions:l.reverse().concat(\"*\")}:{}),o?{href:o}:{}),u?{src:u}:{})},s=!1,d=1,h=window.innerWidth,p=window.innerHeight,m=new Set;var g=function(t){var e=t._element_path,n=t.positions,r=t.children;t._checkList=!0;var i=e.split(\"/\").length-2;if(t.fuzzy_positions||(t.fuzzy_positions=[].concat(n)),t.fuzzy_positions[i]=\"*\",r){!function t(e){e.forEach((function(e){e.fuzzy_positions||(e.fuzzy_positions=[].concat(e.positions)),e.fuzzy_positions[i]=\"*\",e.children&&t(e.children)}))}(r)}},y=function e(n){return Array.prototype.slice.call(n,0).reduce((function(n,r){if(!r)return n;var i=r.nodeName;if(function(t){return[\"script\",\"link\",\"style\",\"embed\"].includes(t)}(i=i.toLowerCase())||function(t){var e=getComputedStyle(t,null);if(\"none\"===e.getPropertyValue(\"display\"))return!0;if(\"0\"===e.getPropertyValue(\"opacity\"))return!0;return!1}(r))return n;var o=function(t){var e=arguments.length>1&&void 0!==arguments[1]?arguments[1]:1,n=t.getBoundingClientRect().toJSON();if(1===e)return n;return Object.keys(n).reduce((function(t,r){return t[r]=Math.ceil(n[r]*e),t}),{})}(r,d);if(!function(t,e){var n=t.left,r=t.right,i=t.top,o=t.bottom,a=t.width,u=t.height,c=!(a>0&&u>0),l=getComputedStyle(e,null);if(![\"\",\"static\"].includes(l.getPropertyValue(\"position\"))){if(c&&!e.children.length)return!1;var f=l.getPropertyValue(\"z-index\");if(\"auto\"!==f&&parseInt(f,10)<0)return!1;return!0}if(c)return!1;if(n>window.innerWidth||r<0||i>window.innerHeight||o<0)return!1;return!0}(o,r))return n;o=function(t){var e={x:t.left,y:t.top,width:t.width,height:t.height};return t.top<0&&(e.y=0,e.height+=t.top),t.bottom>p&&(e.height=p-e.y),t.left<0&&(e.x=0,e.width+=t.left),t.right>h&&(e.width=h-e.x),Object.keys(e).forEach((function(t){e[t]=Math.floor(e[t])})),e}(o);var a={};if(!function(t){return[\"button\",\"select\"].includes(t)}(i)&&r.children){var u=e(r.children);u&&u.length&&(a={children:u})}var c=f(r),l=c._element_path,s=!1;if(m.has(l))s=!0;else{var y=r.parentElement;if(y){var v=y.children,b=Array.from(v).filter((function(t){return t.nodeName.toLowerCase()===i})),w=b.length;if(w>=3){var A=Array.from(r.classList),_=A.length,O=Array.from(r.children).map((function(t){return t.nodeName.toLowerCase()})).join(\",\"),x=0;Array.from(b).forEach((function(e){if(e===r)return x++,void 0;var n=!1;if(_){var i=Array.from(e.classList);A.length+i.length-new Set([].concat(t(i),t(A))).size>0&&(n=!0)}else n=!0;if(n){var o=!1;if(O)Array.from(e.children).map((function(t){return t.nodeName.toLowerCase()})).join(\",\")===O&&(o=!0);else o=!0;o&&x++}})),x>=3&&x/w>=.5&&(s=!0),s&&m.add(l)}}}return c=Object.assign(Object.assign({nodeName:i,frame:o},c),a),s&&g(c),c.children&&c.children.forEach((function(t){var e=t._element_path,n=t._checkList;m.has(e)&&!n&&g(t)})),n.push(c),n}),[])},v=function(){if(s)return;s=!0,d=function(){try{var t=window.outerWidth/window.innerWidth;if(1===t)return 1;if(t)return t;var e=document.querySelector('meta[name=\"viewport\"]');if(e){var n=e.content.match(/initial-scale=(.*?)(,|$)/);if(n&&n[1]){var r=parseFloat(n[1]);if(r)return r}}}catch(t){return 1}return 1}(),h=window.innerWidth*d,p=window.innerHeight*d,m=new Set},b=function(t){return JSON.stringify(t)};if(!window.TEAWebviewInfo){var w=[],A=function(){var t=arguments.length>0&&void 0!==arguments[0]&&arguments[0];if(w.length)return console.log(w.length,w),b({value:w.shift(),done:!w.length});v();try{var e=y(document.querySelectorAll(\"body > *\")),n={page:window.location.href,info:e},r=b(n);if(console.log(r),!t)return r;if(1===(w=l(r)).length)return w.shift();return console.log(w.length,w),b({value:w.shift(),done:!1})}catch(t){console.log(t)}return\"\"};A.version=\"1.2.0\",window.TEAWebviewInfo=A}}();\n";
    public static final String JS_URL_PREFIX = "javascript:";

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/util/WebViewJsUtil$b.class */
    public interface b {
        void a(String str);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/util/WebViewJsUtil$c.class */
    public static class c {
        public c() {
        }

        public /* synthetic */ c(a aVar) {
        }

        @JavascriptInterface
        public void postMessage(String str) {
            z2.a("WebViewJsUtil postMessage to native: " + str);
            WebViewJsUtil.sendWebClick(str);
        }
    }

    public static /* synthetic */ void a(Handler handler, WebView webView, String str) {
        if (handler != null) {
            if (TextUtils.isEmpty(str)) {
                z2.a("WebViewJsUtil getWebInfo:null!");
            }
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.obj = webView;
            obtainMessage.getData().putString(BUNDLE_WEB_INFO, str);
            handler.sendMessage(obtainMessage);
        }
    }

    public static /* synthetic */ void a(String str) {
    }

    public static /* synthetic */ boolean a(com.bytedance.bdtracker.c cVar) {
        return (!cVar.isH5CollectEnable() || cVar.getInitConfig() == null || cVar.getInitConfig().getPicker() == null || TextUtils.isEmpty(cVar.getInitConfig().getPicker().getMarqueeCookie())) ? false : true;
    }

    public static z1 create(String str, String str2, boolean z, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            z2.b("WebView send event without name, ignored.", (Throwable) null);
            return null;
        }
        z1 z1Var = new z1(null, str, z, jSONObject != null ? jSONObject.toString() : null);
        if (!TextUtils.isEmpty(str)) {
            try {
                z1Var.a(Long.parseLong(str2));
                return z1Var;
            } catch (NumberFormatException e) {
                z2.c("U SHALL NOT PASS!", e);
            }
        }
        return z1Var;
    }

    public static void evaluateJavascript(View view, String str) {
        evaluateJavascript(view, str, new b() { // from class: com.bytedance.applog.util.-$$Lambda$yYtM2z71lTciB9I8-sAa6TCuAOU
            @Override // com.bytedance.applog.util.WebViewJsUtil.b
            public final void a(String str2) {
                WebViewJsUtil.a(str2);
            }
        });
    }

    public static void evaluateJavascript(View view, String str, final b bVar) {
        if (k2.a(view)) {
            if (Build.VERSION.SDK_INT < 19) {
                loadUrl(view, getJsCodeUrl(str), null);
            } else if (k2.b(view)) {
                bVar.getClass();
                ((com.tencent.smtt.sdk.WebView) view).evaluateJavascript(str, new ValueCallback() { // from class: com.bytedance.applog.util.-$$Lambda$KJarss4L65HzwuTLw2escEMjcbM
                    @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        WebViewJsUtil.b.this.a((String) obj);
                    }
                });
            } else {
                bVar.getClass();
                ((WebView) view).evaluateJavascript(str, new android.webkit.ValueCallback() { // from class: com.bytedance.applog.util.-$$Lambda$lTGpN8JmI2Vjhv-_b5-6Fj7zcFw
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        WebViewJsUtil.b.this.a((String) obj);
                    }
                });
            }
        }
    }

    public static String getJsCodeUrl(String str) {
        StringBuilder a2 = com.bytedance.bdtracker.a.a("javascript:");
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        }
        a2.append(str2);
        return a2.toString();
    }

    public static void getWebInfo(final WebView webView, final Handler handler) {
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript(getJsCodeUrl("TEAWebviewInfo();"), new android.webkit.ValueCallback() { // from class: com.bytedance.applog.util.-$$Lambda$O4mXovdjVipWzRdvrFOlAl_0L3Q
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    WebViewJsUtil.a(Handler.this, webView, (String) obj);
                }
            });
        } else {
            z2.b("WebViewJsUtil Doesn't support evaluateJavascript, can't get return value ", (Throwable) null);
        }
    }

    public static void injectCollectJs(View view, String str) {
        z2.a("WebViewJsUtil collect js to: {}", view);
        String str2 = !com.bytedance.bdtracker.b.b(new b.InterfaceC0306b() { // from class: com.bytedance.applog.util.-$$Lambda$QbdrvTGsbkEc-enup9d6vFYVIaE
            @Override // com.bytedance.bdtracker.b.InterfaceC0306b
            public final boolean a(c cVar) {
                return WebViewJsUtil.a(cVar);
            }
        }) ? JS_CODE_MARQUEE : JS_CODE_COLLECT;
        if (JS_CODE_COLLECT.equals(str2)) {
            z2.a("WebViewJsUtil 圈选");
        }
        if (getJsCodeUrl(str2).equals(str)) {
            return;
        }
        evaluateJavascript(view, str2);
    }

    public static void injectNativeReportCallback(View view) {
        z2.a("WebViewJsUtil add interface:TEANativeReport to: {}", view);
        j1.a(view, (Object) new c(null), "TEANativeReport");
    }

    public static void loadData(View view, String str, String str2, String str3) {
        if (k2.a(view)) {
            try {
                view.getClass().getMethod("loadData", String.class, String.class, String.class).invoke(view, str, str2, str3);
            } catch (Throwable th) {
                z2.a(th);
            }
        }
    }

    public static void loadDataWithBaseURL(View view, String str, String str2, String str3, String str4, String str5) {
        if (k2.a(view)) {
            try {
                view.getClass().getMethod("loadDataWithBaseURL", String.class, String.class, String.class, String.class, String.class).invoke(view, str, str2, str3, str4, str5);
            } catch (Throwable th) {
                z2.a(th);
            }
        }
    }

    public static void loadUrl(View view, String str, Map<String, String> map) {
        if (k2.a(view)) {
            try {
                view.getClass().getMethod("loadUrl", String.class, Map.class).invoke(view, str, map);
            } catch (Throwable th) {
                z2.a(th);
            }
        }
    }

    public static void sendWebClick(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    return;
                }
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String string = jSONObject.getString("event");
                String string2 = jSONObject.getString("local_time_ms");
                boolean z = true;
                if (jSONObject.getInt("is_bav") != 1) {
                    z = false;
                }
                z1 create = create(string, string2, z, jSONObject.getJSONObject("params"));
                if (create != null) {
                    com.bytedance.bdtracker.b.a(create, com.bytedance.bdtracker.b.f21195c);
                }
                i = i2 + 1;
            }
        } catch (JSONException e) {
            z2.c("U SHALL NOT PASS!", e);
        }
    }
}
