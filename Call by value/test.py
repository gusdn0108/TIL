import requests
import pandas as pd
import xlwings as xw
import time

CLIENT_ID = 'xlnd2vbbvd'
CLIENT_SECRET = '4a1rR68T7Z3uTZTyz40PlNCfxVVHgDwVk0b7kubW'
URL = 'https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode'

wb = xw.Book('test.xlsx')
sht = wb.sheets[0]



address =  '인천 중구 무의동 3'

geocode_url = f'https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query={address}'

headers = {
    'X-NCP-APIGW-API-KEY-ID': CLIENT_ID,
    'X-NCP-APIGW-API-KEY': CLIENT_SECRET
}

geocode_response = requests.get(geocode_url, headers=headers)

if geocode_response.status_code == 200:
    geocode_data = geocode_response.json()
    if geocode_data.get('addresses'):
        place = geocode_data.get('addresses')[0]
        x = place.get('x')
        y = place.get('y')

        search_url = f'https://naveropenapi.apigw.ntruss.com/map-place/v1/search?query=하나개분식&coordinate={x},{y}'
        
        search_response = requests.get(search_url, headers=headers)
       
        if search_response.status_code == 200:
            search_data = search_response.json()
            places = search_data.get('places')
            for place in places:
                name = place.get('name')
                print(f'가게 이름: {name}')
        else:
            print(f'가게없음: {search_response.status_code}')
    else:
        print('주소 없음')
else:
    print(f'리스폰 못받음 {geocode_response.status_code}')






