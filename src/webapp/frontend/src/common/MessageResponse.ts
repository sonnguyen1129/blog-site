/* eslint-disable */
export class MessageResponse {
  public static SUCCESS: string = 'SUCCESS';

  constructor(init?: Partial<MessageResponse>) {
    Object.assign(this, init);
  }
}
